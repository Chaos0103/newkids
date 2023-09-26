import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/quiz/Title';
import Question from 'components/atoms/quiz/Question';
import QuizExamples from 'components/atoms/quiz/QuizExamples';
// import Button from 'components/atoms/common/Button';
import { WeeklyQuizQuestionRequestApiBody } from 'types/api';
import { DUMMY_WEEKLY_QUIZS } from 'constants/dummyquiz';
import Button from 'components/atoms/common/Button';
import { QuizQuestionContainer } from './style';

interface IQuizQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function QuizQuestion(props: IQuizQuestionProps) {
	const { setStep } = props;
	const [isDone, setIsDone] = useState(false);
	const [question, setQuestion] = useState<WeeklyQuizQuestionRequestApiBody[]>(DUMMY_WEEKLY_QUIZS);

	const handleClick = () => {
		if (!isDone) {
			setStep(3);
			console.log('클릭했습니다.');
		} else {
			console.log('변경이 안됐습니다.');
		}
	};

	useEffect(() => {
		setQuestion(DUMMY_WEEKLY_QUIZS);
		setIsDone(false);
	});

	// console.log(question);
	// question.forEach((que) => {
	// 	console.log(que);
	// 	return (
	// 		<QuizQuestionContainer>
	// 			<Title effectText={que.no} text="" />
	// 			<h1 className="meaning">뜻)</h1>
	// 			<Question text={que.description} />
	// 			<hr className="hr" />
	// 			<QuizExamples />
	// 		</QuizQuestionContainer>
	// 	);
	// });

	for (let i = 0; i < question.length; i += 1) {
		const element = question[i];
		if (i === 0) {
			return (
				<QuizQuestionContainer>
					<Title effectText={element.no} text="번 문제" />
					<h1 className="meaning">뜻)</h1>
					<Question text={element.description} />
					<hr className="hr" />
					<QuizExamples />
					<div className="quiz-button">
						<Button size="m" radius="m" color="SubFirst" text="다음으로" handleClick={handleClick} />
					</div>
				</QuizQuestionContainer>
			);
		}
	}

	// return (
	// 	<QuizQuestionContainer>
	// 		<Title text="번 문제" effectText="" />
	// 		<Question text="OOO는 원래 은하를 뜻하는 영어단어에요. 항성, 밀집성, 성간 물질 등 중력에 의해 뭉친 거대한 천체를 뜻합니다. 우리나라에서는 스마트폰 브랜드 이름으로 유명해요. 이 키워드는 무엇일까요?" />
	// 		<QuizExamples />
	// 		<div className="quiz-button">
	// 			<Button size="s" radius="m" color="SubFirst" text="결과는?" handleClick={handleClick} />
	// 		</div>
	// 	</QuizQuestionContainer>
	// );
}

export default QuizQuestion;
