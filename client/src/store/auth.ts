import { atom } from 'recoil';
import { IAuth, IMember } from 'types/auth';

export const AuthState = atom<IAuth | null>({
	key: 'AuthState',
	default: null,
});

export const MemberInfoState = atom<IMember | null>({
	key: 'memberInfoState',
	default: null,
});
