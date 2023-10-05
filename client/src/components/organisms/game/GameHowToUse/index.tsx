import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/game/Title';
import HowToUseExplainOne from 'components/atoms/game/HowToUseExplainOne';
import HowToUseExplainTwo from 'components/atoms/game/HowToUseExplainTwo';
import HowToUseExplainThree from 'components/atoms/game/HowToUseExplainThree';
import Button from 'components/atoms/common/Button';
import { startQuizApi } from 'utils/apis/quiz';
import HowToUseLottie from 'components/atoms/lottie/HowToUseLottie';
import ScrollToTop from 'components/atoms/common/ScrollToTop';
import { GameHowToUseContainer } from './style';

interface IGameHowToUseProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function GameHowToUse({ setStep }: IGameHowToUseProps) {
	const [isDone, setIsDone] = useState(false);
	const [num, setNum] = useState(0);

	const startQuiz = async () => {
		try {
			const memberkey = localStorage.getItem('memberkey');
			if (memberkey) {
				await startQuizApi(memberkey);
			}
		} catch (e) {
			console.log(e);
		}
	};

	const handleClick = () => {
		if (!isDone) {
			setStep(2);
			setNum(1);
			setIsDone(true);
		}
	};

	useEffect(() => {
		if (num === 0) {
			startQuiz();
			setIsDone(false);
		}
	}, [num]);

	return (
		<GameHowToUseContainer>
			<ScrollToTop />
			<HowToUseLottie />
			<Title effectText="단어 듣고 맞추기" text=" 이용방법" />
			<HowToUseExplainOne />
			<HowToUseExplainTwo />
			<HowToUseExplainThree />
			<div className="quiz-button">
				<Button size="s" radius="m" color="Primary" text="다음" handleClick={handleClick} />
			</div>
		</GameHowToUseContainer>
	);
}

export default GameHowToUse;
