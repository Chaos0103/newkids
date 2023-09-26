import {
	QuizAnswerCheckApiBody,
	QuizQuestionRequestApiBody,
	WeeklyQuizAnswerCheckApiBody,
	WeeklyQuizQuestionRequestApiBody,
} from 'types/api';

export const DUMMY_QUIZS: QuizQuestionRequestApiBody[] = [
	{ no: 1, word: '업적', description: '어떤 사업이나 연구 따위에서 세운 공적을 뜻해요.' },
	{ no: 2, word: '조찬익', description: '싸피 교육생이에요.' },
	{ no: 3, word: '싸피', description: '삼성 청년 SW 아카데미의 줄임말을 뜻해요.' },
	{ no: 4, word: '짱이에요', description: '진짜 짱이에요.' },
	{ no: 5, word: '으악', description: '프로젝트 무사히 끝냅시다.' },
];

export const DUMMY_ANSWERS_1: QuizAnswerCheckApiBody[] = [{ answer: '업적' }];

export const DUMMY_WEEKLY_QUIZS: WeeklyQuizQuestionRequestApiBody[] = [
	{
		no: 1,
		answerword: '아스날',
		description: '챔스 우승이 없어요.',
		contents: ['아스날', '맨유', '첼시', '리버풀'],
	},
	{
		no: 2,
		answerword: '조찬익',
		description: '지금 제일 프로젝트를 하기 싫은 사람은 누구인가요?',
		contents: ['조찬익', '조찬익2', '조찬익3', '조찬익4'],
	},
	{
		no: 3,
		answerword: '팀장님',
		description: '다음 중 C205멤버인 사람은?',
		contents: ['신성주', '이금규', '팀장님', '컨설턴트'],
	},
	{
		no: 4,
		answerword: '아스날',
		description: '진짜 챔스 우승이 없어요.',
		contents: ['아스날', '맨유', '첼시', '리버풀'],
	},
	{
		no: 5,
		answerword: '아스날',
		description: '아직도 챔스 우승이 없어요.',
		contents: ['아스날', '맨유', '첼시', '리버풀'],
	},
];

export const DUMMY_WEEKLY_ANSWERS_1: WeeklyQuizAnswerCheckApiBody[] = [{ answer: '아스날' }];
