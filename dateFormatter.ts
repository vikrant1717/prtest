export const formatRelativeTime = (date: Date): string => {
  const diff = new Date().getTime() - date.getTime();
  const seconds = Math.floor(diff / 1000);
  if (seconds < 60) return 'Just now';
  return date.toLocaleDateString();
};