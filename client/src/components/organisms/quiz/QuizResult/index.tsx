import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/quiz/Title';
import Button from 'components/atoms/common/Button';
import QuizSubImage from 'components/atoms/quiz/QuizSubImage';
import { QuizResultWrapper } from './style';

interface IQuizResultProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function QuizResult({ setStep }: IQuizResultProps) {
	const [isDone, setIsDone] = useState(false);
	const [num, setNum] = useState(0);

	const handleClick = () => {
		if (!isDone) {
			setStep(4);
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
		<QuizResultWrapper>
			<QuizSubImage />
			<Title text="최종 점수" effectText="" />
			<div className="score-wrapper">
				<h1 className="score">이것도 점수냐?</h1>
			</div>
			<div className="sub-title-wrapper">
				<h1 className="sub-title">총 맞춘 문제</h1>
			</div>
			<div className="answer-wrapper">
				<h1 className="answer">하기 싫누...</h1>
			</div>
			<div className="exp-wrapper">경험치바가 들어갈 공간입니다.</div>
			<div className="quiz-button">
				<Button size="s" radius="m" color="SubFirst" text="확인" handleClick={handleClick} />
			</div>
		</QuizResultWrapper>
	);
}

export default QuizResult;
