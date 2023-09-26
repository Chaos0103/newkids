import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/quiz/Title';
import Button from 'components/atoms/common/Button';
import GameCompleteLottie from 'components/atoms/lottie/GameCompleteLottie';
import { QuizResultWrapper } from './style';

interface IQuizResultProps {
	setStep: Dispatch<SetStateAction<number>>;
	setScore: Dispatch<SetStateAction<number>>;
	score: number;
}

function QuizResult(props: IQuizResultProps) {
	const { setStep, setScore, score } = props;
	const [isDone, setIsDone] = useState(false);
	const [num, setNum] = useState(0);

	console.log(setScore);

	const handleClick = () => {
		if (!isDone) {
			setStep(4);
			setNum(1);
		}
	};

	useEffect(() => {
		if (num === 0) {
			setIsDone(false);
		}
	}, [num]);

	return (
		<QuizResultWrapper>
			<GameCompleteLottie />
			<Title text="최종 점수" effectText="" />
			<div className="score-wrapper">
				<h1 className="score">{score * 10} 점</h1>
			</div>
			<div className="sub-title-wrapper">
				<h1 className="sub-title">총 맞춘 문제</h1>
			</div>
			<div className="answer-wrapper">
				<h1 className="answer">{score} 문제</h1>
			</div>
			{/* <div className="exp-wrapper">경험치바가 들어갈 공간입니다.</div> */}
			<div className="quiz-button">
				<Button size="s" radius="m" color="SubFirst" text="확인" handleClick={handleClick} />
			</div>
		</QuizResultWrapper>
	);
}

export default QuizResult;
