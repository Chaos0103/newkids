import { CheckEmailApiBody, CheckNicknameApiBody, JoinApiBody, LoginApiBody, PatchPasswordApiBody } from 'types/api';
import { instance } from './instance';

// 로그인
export const loginApi = async (body: LoginApiBody) => {
	const response = await instance.post('/user-service/login', JSON.stringify(body));
	return response;
};

// 회원가입
export const joinApi = async (body: JoinApiBody) => {
	const response = await instance.post('/user-service/join', JSON.stringify(body));
	return response;
};

// 사용자 정보 조회
export const getMemberInfoApi = async (key: string) => {
	const response = await instance.get(`/user-service/${key}/info`);
	return response;
};

// 회원 탈퇴
export const withdrawalApi = async (key: string) => {
	const response = await instance.delete(`/user-service/${key}/withdrawal`);
	return response;
};

// 이메일 중복 체크
export const checkEmailApi = async (body: CheckEmailApiBody) => {
	const response = await instance.post('/user-service/auth/email', JSON.stringify(body));
	return response;
};

// 닉네임 중복 체크
export const checkNicknameApi = async (body: CheckNicknameApiBody) => {
	const response = await instance.post('/user-service/auth/nickname', JSON.stringify(body));
	return response;
};

// 비밀번호 변경
export const patchPasswordApi = async (key: string, body: PatchPasswordApiBody) => {
	const response = await instance.patch(`/user-service/${key}/password`, body);
	return response;
};
