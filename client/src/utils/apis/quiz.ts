import { QuizAnswerCheckApiBody, QuizQuestionRequestApiBody, WeeklyQuizAnswerCheckApiBody } from 'types/api';
import { instance } from './instance';

// Quiz

// 퀴즈 단어 호출
export const getQuizQuestionApi = async (memberkey: string, body: QuizQuestionRequestApiBody) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/next`, JSON.stringify(body));
	return response;
};

// 퀴즈 정답 체크
export const checkAnswerApi = async (memberkey: string, body: QuizAnswerCheckApiBody) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/answer`, JSON.stringify(body));
	return response;
};

// Weekly Quiz

// 주간 어휘 단어 호출
export const getWeeklyQuizQuestionApi = async (memberkey: string) => {
	const response = await instance.post(`/quiz-service/api/${memberkey}/weekly/next`);
	return response;
};

// 주간 어휘 퀴즈 정답 체크
export const checkWeeklyAnswerApi = async (memberKey: string, body: WeeklyQuizAnswerCheckApiBody) => {
	const response = await instance.post(`/quiz-service/api/${memberKey}/weekly/answer`, JSON.stringify(body));
	return response;
};
