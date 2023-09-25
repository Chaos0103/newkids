import { QuizAnswerCheckApiBody, WeeklyQuizAnswerCheckApiBody } from 'types/api';
import { instance } from './instance';

// Quiz

// 퀴즈 정답 체크
export const checkAnswerApi = async (memberkey: string, body: QuizAnswerCheckApiBody) => {
	const response = await instance.post(`/quiz-controller/${memberkey}/answer`, JSON.stringify(body));
	return response;
};

// Weekly Quiz

// 주간 어휘 퀴즈 정답 체크
export const checkWeeklyAnswerApi = async (memberKey: string, body: WeeklyQuizAnswerCheckApiBody) => {
	const response = await instance.post(`/quiz-controller/${memberKey}/weekly/answer`, JSON.stringify(body));
	return response;
};
