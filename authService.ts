import { User, UserRole } from './types';

export class AuthService {
  private static readonly AUTH_KEY = 'auth_token';

  static isAuthenticated(): boolean {
    return !!localStorage.getItem(this.AUTH_KEY);
  }

  static async getCurrentUser(): Promise<User | null> {
    // Simulating an API call
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve({
          id: '123',
          email: 'hello@example.com',
          username: 'gemini_dev',
          role: UserRole.ADMIN,
          createdAt: new Date(),
          isActive: true,
        });
      }, 500);
    });
  }

  static logout(): void {
    localStorage.removeItem(this.AUTH_KEY);
    window.location.href = '/login';
  }
}