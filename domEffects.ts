export const fadeIn = (element, duration = 500) => {
  element.style.opacity = 0;
  element.style.display = 'block';
  element.style.transition = `opacity ${duration}ms ease-in`;
  setTimeout(() => (element.style.opacity = 1), 10);
};