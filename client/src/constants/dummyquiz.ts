import {
	QuizAnswerCheckApiBody,
	QuizQuestionRequestApiBody,
	WeeklyQuizAnswerCheckApiBody,
	WeeklyQuizQuestionRequestApiBody,
} from 'types/api';

export const DUMMY_QUIZS: QuizQuestionRequestApiBody[] = [
	{ no: 1, word: '업적', description: '어떤 사업이나 연구 따위에서 세운 공적을 뜻한다.' },
	{ no: 2, word: '정원', description: '집 안에 있는 뜰이나 꽃밭, 일정한 규정에 의하여 정한 인원' },
	{ no: 3, word: '금일', description: '지금 지나가고 있는 바로 이날, 이제까지의 매우 짧은 동안' },
	{
		no: 4,
		word: '양성',
		description: '가르쳐서 유능한 사람을 길러낸다. 병을 진단하기 위하여 검사를 한 결과 특정한 반응이 나타나는 일',
	},
	{ no: 5, word: '심심', description: '여래의 본원을 깊이 믿는 마음. 온갖 선행을 닦고자 하는 굳은 마음' },
	{ no: 6, word: '참여', description: '어떤 일에 끼어들어 관계함' },
	{
		no: 7,
		word: '기각',
		description: '소송을 수리한 법원이 형식적인 요건을 갖추었으나 그 내용이 이유가 없다고 취소하는 일',
	},
	{ no: 8, word: '대치', description: '다른 것으로 바꾸어 놓음, 서로 맞서서 버팀' },
	{ no: 9, word: '실기', description: '실제의 기능이나 기술' },
	{ no: 10, word: '지양', description: '더 높은 단계로 오르기 위하여 어떠한 것을 하지 아니함' },
];

export const DUMMY_ANSWERS_1: QuizAnswerCheckApiBody[] = [{ answer: '업적' }];

export const DUMMY_WEEKLY_QUIZS: WeeklyQuizQuestionRequestApiBody[] = [
	{
		no: 1,
		answerword: '리비아',
		description:
			'북아프리카에 있는 나라로 수도는 트리폴리이며, 공용어는 아랍어이다. 최근 대홍수가 일어나 극심한 피해를 입은 나라다.',
		contents: ['이집트', '리비아', '모로코', '아랍에미리트'],
	},
	{
		no: 2,
		answerword: '플로깅',
		description:
			'줍다라는 뜻의 스웨덴 어 "플로카 업"과 달리다 라는 "조깅"을 합성한 단어다. 또한 쓰레기를 주우며 조깅하는 행동을 의미하는 단어다',
		contents: ['플로깅', '플로조', '트래시런닝', '기브업런닝'],
	},
	{
		no: 3,
		answerword: '분화구',
		description: '화산 활동, 운석 충돌 등 거대한 충격으로 인해 표면에 생겨나는 구덩이를 뜻한다.',
		contents: ['열점', '암맥', '분화구', '칼데라'],
	},
	{
		no: 4,
		answerword: '업사이클링',
		description:
			'1994년 리너 필츠 (Reiner Pilz)가 처음 사용한 개념이다. 그 소용이 다해 버려지는 제품을 단순히 재활용하는 차원을 넘어 디자 인을 가미하는 등의 새로운 부가가치를 창출하여 새 제 품으로 재탄생시키는 일체의 행위를 뜻하는 단어다.',
		contents: ['비치코밍', 'CAI', '재활용', '업사이클링'],
	},
	{
		no: 5,
		answerword: 'SSAFY',
		description: '삼성 청년 SW 아카데미의 줄임말로써 미래 SW 인재 육성에 힘쓰고 있는 이 기관은 무엇일까?',
		contents: ['우테코', 'SSAFY', '네부캠', '소마'],
	},
];

export const DUMMY_WEEKLY_ANSWERS_1: WeeklyQuizAnswerCheckApiBody[] = [{ answer: '아스날' }];
