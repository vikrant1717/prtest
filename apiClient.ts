export interface ApiResponse<T> {
  data: T | null;
  error: string | null;
  status: number;
}

export async function apiRequest<T>(url: string, options?: RequestInit): Promise<ApiResponse<T>> {
  try {
    const response = await fetch(url, options);
    const data = await response.json();
    return { data, error: null, status: response.status };
  } catch (error) {
    return { data: null, error: (error as Error).message, status: 500 };
  }
}