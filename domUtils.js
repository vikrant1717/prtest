/**
 * Utility for handling common DOM operations
 */

export const debounce = (func, delay = 300) => {
  let timeoutId;
  return (...args) => {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(() => {
      func.apply(null, args);
    }, delay);
  };
};

export const getElement = (selector) => {
  const el = document.querySelector(selector);
  if (!el) {
    throw new Error(`Element with selector "${selector}" not found.`);
  }
  return el;
};