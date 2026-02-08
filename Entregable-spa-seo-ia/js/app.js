/* 1) Año automático en el footer */
const yearEl = document.getElementById("year");
if (yearEl) yearEl.textContent = new Date().getFullYear();

/* 2) Menú activo según sección visible */
const navLinks = Array.from(document.querySelectorAll(".nav a"));

// Solo links internos tipo "#seccion"
const sectionLinks = navLinks.filter((a) => {
  const href = a.getAttribute("href") || "";
  return href.startsWith("#") && href.length > 1;
});

// Secciones reales a observar
const sections = sectionLinks
  .map((a) => document.querySelector(a.getAttribute("href")))
  .filter(Boolean);

if (sections.length > 0) {
  const observer = new IntersectionObserver(
    (entries) => {
      const visible = entries.filter((e) => e.isIntersecting);
      if (visible.length === 0) return;

      visible.sort((a, b) => b.intersectionRatio - a.intersectionRatio);
      const current = visible[0].target;

      // Activar link correspondiente
      navLinks.forEach((a) => a.classList.remove("active"));
      const id = `#${current.id}`;
      const activeLink = navLinks.find((a) => a.getAttribute("href") === id);
      if (activeLink) activeLink.classList.add("active");
    },
    {
      threshold: [0.15, 0.3, 0.6],
      rootMargin: "-20% 0px -60% 0px",
    }
  );

  sections.forEach((sec) => observer.observe(sec));
}

/* 3) Form demo: evita envío real y muestra confirmación */
function attachDemoFormHandler(formId, successMessage) {
  const form = document.getElementById(formId);
  if (!form) return;

  form.addEventListener("submit", (e) => {
    e.preventDefault();
    alert(successMessage);
    form.reset();
  });
}

attachDemoFormHandler(
  "form-contacto",
  "✅ Mensaje preparado (demo). En un sitio real, esto se enviaría al correo/WhatsApp de la óptica."
);

