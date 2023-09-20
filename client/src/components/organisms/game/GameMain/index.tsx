import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/game/Title';
import QuizImage from 'components/atoms/quiz/QuizImage';
import Explain from 'components/atoms/game/Explain';
import Button from 'components/atoms/common/Button';
import Swal from 'sweetalert2';
import 'animate.css';
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

	const alertClick = () => {
		if (!isDone) {
			Swal.fire({
				title: '이런! 단어장에 단어를 추가하세요.',
				html: `단어장에 단어가 없어요. <br /> 기사를 읽고 단어를 추가하면 컨텐츠를 진행할 수 있어요.`,
				confirmButtonText: '기사 보러가기',
				confirmButtonColor: 'var(--main-color)',
				showClass: {
					popup: 'animate__animated animate__fadeInDown',
				},
				hideClass: {
					popup: 'animate__animated animate__fadeOutUp',
				},
			});
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
				<Button size="l" radius="m" color="Primary" text="alert 테스트용입니다." handleClick={alertClick} />
			</div>
		</GameMainContainer>
	);
}

export default GameMain;
