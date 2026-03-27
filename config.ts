interface AppConfig {
  apiUrl: string;
  timeout: number;
  retries: number;
}

export const CONFIG: AppConfig = {
  apiUrl: process.env.API_URL || 'https://api.example.com',
  timeout: 5000,
  retries: 3,
}