export enum UserRole {
  ADMIN = 'ADMIN',
  EDITOR = 'EDITOR',
  VIEWER = 'VIEWER',
}

export interface User {
  id: string;
  email: string;
  username: string;
  role: UserRole;
  createdAt: Date;
  isActive: boolean;
}

export type UserUpdatePayload = Partial<Omit<User, 'id' | 'createdAt'>>;