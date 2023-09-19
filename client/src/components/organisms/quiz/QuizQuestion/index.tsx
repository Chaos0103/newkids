import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/quiz/Title';
import Question from 'components/atoms/quiz/Question';
import QuizExamples from 'components/atoms/quiz/QuizExamples';
import Button from 'components/atoms/common/Button';
import { QuizQuestionContainer } from './style';

interface IQuizQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function QuizQuestion({ setStep }: IQuizQuestionProps) {
	const [isDone, setIsDone] = useState(false);
	const [num, setNum] = useState(0);

	const handleClick = () => {
		if (!isDone) {
			setStep(3);
			setNum(1);
			setIsDone(true);
		}
	};

	useEffect(() => {
		if (num === 0) {
			setIsDone(false);
		}
	}, [num]);

	return (
		<QuizQuestionContainer>
			<Title text="번 문제" effectText="" />
			<Question text="OOO는 원래 은하를 뜻하는 영어단어에요. 항성, 밀집성, 성간 물질 등 중력에 의해 뭉친 거대한 천체를 뜻합니다. 우리나라에서는 스마트폰 브랜드 이름으로 유명해요. 이 키워드는 무엇일까요?" />
			<QuizExamples />
			<div className="quiz-button">
				<Button size="s" radius="m" color="SubFirst" text="결과는?" handleClick={handleClick} />
			</div>
		</QuizQuestionContainer>
	);
}

export default QuizQuestion;
