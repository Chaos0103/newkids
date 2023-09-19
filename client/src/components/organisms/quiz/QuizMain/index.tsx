import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/quiz/Title';
import QuizImage from 'components/atoms/quiz/QuizImage';
import Explain from 'components/atoms/quiz/Explain';
import Button from 'components/atoms/common/Button';
import { QuizMainContainer } from './style';

interface IQuizMainProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function QuizMain({ setStep }: IQuizMainProps) {
	const [isDone, setIsDone] = useState(false);
	const [num, setNum] = useState(0);

	const handleClick = () => {
		if (!isDone) {
			setStep(1);
			setNum(1);
		} else {
			console.log('변경이 안됐습니다.');
		}
	};

	useEffect(() => {
		if (num === 0) {
			setIsDone(false);
		}
	}, [num]);

	return (
		<QuizMainContainer>
			<Title text="" effectText="주간 단어 퀴즈" />
			<QuizImage />
			<Explain />
			<div className="quiz-button">
				<Button size="l" radius="m" color="SubFirst" text="시작하러 가기!" handleClick={handleClick} />
			</div>
		</QuizMainContainer>
	);
}

export default QuizMain;
