import { instance } from './instance';

// Quiz

// 퀴즈 시작
export const startQuizApi = async (memberkey: string) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/start`);
	return response;
};

// 퀴즈 단어 호출
export const getQuizQuestionApi = async (memberkey: string) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/next`);
	return response;
};

// 퀴즈 정답 체크
export const checkAnswerApi = async (memberkey: string) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/answer`);
	return response;
};

// 퀴즈 결과
export const resultQuizApi = async (memberkey: string) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/weekly/result`);
	return response;
};

// Weekly Quiz

// 주간 어휘 퀴즈 시작
export const startWeeklyQuizApi = async (memberkey: string) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/weekly/start`);
	return response;
};

// 주간 어휘 단어 호출
export const getWeeklyQuizQuestionApi = async (memberkey: string) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/weekly/next`);
	return response;
};

// 주간 어휘 퀴즈 정답 체크
export const checkWeeklyAnswerApi = async (memberKey: string) => {
	const response = await instance.post(`/quiz-service/api/${memberKey}/weekly/answer`);
	return response;
};

// 주간 어휘 퀴즈 결과
export const resultWeeklyQuizApi = async (memberkey: string) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/weekly/result`);
	return response;
};
