export const isString = (val: unknown): val is string => typeof val === 'string';
export const isNumber = (val: unknown): val is number => typeof val === 'number' && !isNaN(val);

export function assertNever(x: never): never {
  throw new Error(`Unexpected object: ${x}`);
}