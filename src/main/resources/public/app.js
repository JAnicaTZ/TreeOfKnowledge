document.addEventListener('DOMContentLoaded', () => {

  /* ===============================
     Helper: track downloads
     =============================== */
  const trackDownload = (elementId, label) => {
    const el = document.getElementById(elementId);
    if (!el) return;

    el.addEventListener('click', () => {
      if (typeof gtag === 'function') {
        gtag('event', 'download', {
          event_category: 'Downloads',
          event_label: label,
          value: 1
        });
      }
    });
  };

  // JAR downloads
  trackDownload('dl-firstorder-jar', 'FirstOrderLogic – JAR');
  trackDownload('dl-simpleprop-jar', 'SimplePropositionalTree – JAR');
  trackDownload('dl-minimization-jar', 'PropositionalMinimization – JAR');


  /* ===============================
     Copy link button
     =============================== */
  const copyBtn = document.getElementById('copy-link-btn');
  if (copyBtn) {
    copyBtn.addEventListener('click', async () => {
      try {
        await navigator.clipboard.writeText(window.location.href);

        if (typeof gtag === 'function') {
          gtag('event', 'copy_link', {
            event_category: 'Engagement',
            event_label: 'Copy page URL'
          });
        }
      } catch (e) {
        console.error('Copy failed', e);
      }
    });
  }


  /* ===============================
     GitHub / README tracking
     =============================== */
  const trackGitHub = (elementId, label) => {
    const el = document.getElementById(elementId);
    if (!el) return;

    el.addEventListener('click', () => {
      if (typeof gtag === 'function') {
        gtag('event', 'github_click', {
          event_category: 'Engagement',
          event_label: label,
          value: 1
        });
      }
    });
  };

  // Main GitHub repository link (includes README)
  trackGitHub('gh-source', 'GitHub – Repository & README');

});
