type LogLevel = 'info' | 'warn' | 'error';

export const logger = (level: LogLevel, message: string, ...args: any[]) => {
  const timestamp = new Date().toISOString();
  console[level](`[${timestamp}] [${level.toUpperCase()}]: ${message}`, ...args);
};