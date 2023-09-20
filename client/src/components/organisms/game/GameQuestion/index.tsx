import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/game/Title';
import Question from 'components/atoms/quiz/Question';
import Button from 'components/atoms/common/Button';
import Swal from 'sweetalert2';
import { GameQuestionContainer } from './style';

interface IGameQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function GameQuestion({ setStep }: IGameQuestionProps) {
	const [isDone, setIsDone] = useState(false);
	const [num, setNum] = useState(0);

	const handleClick = () => {
		if (!isDone) {
			setStep(3);
			setNum(1);
			setIsDone(true);
		}
	};

	const alertClick = () => {
		if (!isDone) {
			Swal.fire({
				position: 'center',
				imageUrl: 'https://ifh.cc/g/Rkn9J6.jpg',
				imageHeight: 200,
				title: '정답입니다!',
				text: '이미지로 들어가면 될것 같습니다!',
			});
		}
	};

	useEffect(() => {
		if (num === 0) {
			setIsDone(false);
		}
	}, [num]);

	return (
		<GameQuestionContainer>
			<Title text="번 문제" effectText="" />
			<h1 className="meaning">뜻)</h1>
			<Question text="어떤 사업이나 연구 따위에서 세운 공적을 뜻해요." />
			<hr className="hr" />
			<div className="input-wrapper">
				<input type="text" placeholder="정답을 입력해주세요!" className="input" />
				<Button size="s" radius="m" color="Primary" text="제출" handleClick={alertClick} />
			</div>
			<div className="quiz-button">
				<Button size="s" radius="m" color="Primary" text="결과는?" handleClick={handleClick} />
			</div>
		</GameQuestionContainer>
	);
}

export default GameQuestion;
