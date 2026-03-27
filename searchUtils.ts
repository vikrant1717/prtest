export function filterItems<T>(items: T[], query: string, key: keyof T): T[] {
  return items.filter(item => 
    String(item[key]).toLowerCase().includes(query.toLowerCase())
  );
}