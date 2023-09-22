import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/game/Title';
import QuizImage from 'components/atoms/quiz/QuizImage';
import Explain from 'components/atoms/game/Explain';
import Button from 'components/atoms/common/Button';
import { GameMainContainer } from './style';

interface IGameMainProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function GameMain({ setStep }: IGameMainProps) {
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
		<GameMainContainer>
			<Title text="" effectText="단어 듣고 맞추기" />
			<QuizImage />
			<Explain />
			<div className="quiz-button">
				<Button size="l" radius="m" color="Primary" text="시작하러 가기!" handleClick={handleClick} />
			</div>
		</GameMainContainer>
	);
}

export default GameMain;
