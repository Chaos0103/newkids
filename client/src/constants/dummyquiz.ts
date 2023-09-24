import { QuizAnswerCheckApiBody, QuizQuestionRequestApiBody } from 'types/api';
// import { WeeklyQuizAnswerCheckApiBody } from 'types/api';

export const DUMMY_ANSWERS_1: QuizAnswerCheckApiBody[] = [{ answer: '업적' }];

export const DUMMY_QUIZS: QuizQuestionRequestApiBody[] = [
	{ no: '1', word: '업적', description: '어떤 사업이나 연구 따위에서 세운 공적을 뜻해요.' },
	{ no: '2', word: '조찬익', description: '어떤 사업이나 연구 따위에서 세운 공적을 뜻해요.' },
	{ no: '3', word: '싸피', description: '어떤 사업이나 연구 따위에서 세운 공적을 뜻해요.' },
	{ no: '4', word: '짱이에요', description: '어떤 사업이나 연구 따위에서 세운 공적을 뜻해요.' },
];
export const DUMMY_QUIZS_2: QuizQuestionRequestApiBody[] = [
	{
		no: '2',
		word: '조찬익',
		description: 'SSAFY에 다니고 있는 교육생 중 한 명이에요. 현재 C205 소속으로 프론트엔드를 담당하고 있습니다.',
	},
];
