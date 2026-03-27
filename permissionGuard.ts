import { UserRole } from './types';

export const canAccess = (userRole: UserRole, requiredRole: UserRole): boolean => {
  const hierarchy: Record<UserRole, number> = {
    [UserRole.ADMIN]: 3,
    [UserRole.EDITOR]: 2,
    [UserRole.VIEWER]: 1,
  };
  return hierarchy[userRole] >= hierarchy[requiredRole];
};