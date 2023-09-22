import React, { Dispatch, SetStateAction, useState } from 'react';
import Title from 'components/atoms/game/Title';
import Question from 'components/atoms/quiz/Question';
import Alert from 'components/organisms/common/Alert';
import Input from 'components/atoms/common/Input';
import { GameQuestionContainer } from './style';

interface IGameQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function GameQuestion({ setStep }: IGameQuestionProps) {
	const [answer, setAnswer] = useState('');

	return (
		<GameQuestionContainer>
			<Title text="번 문제" effectText="" />
			<h1 className="meaning">뜻)</h1>
			<Question text="어떤 사업이나 연구 따위에서 세운 공적을 뜻해요." />
			<hr className="hr" />
			<div className="input-wrapper">
				<Input type="text" value={answer} setValue={setAnswer} placeholder="정답을 입력해주세요." />
				<Alert
					setStep={setStep}
					imageUrls="https://ifh.cc/g/Rkn9J6.jpg"
					imageHeights={200}
					titles="정답입니다"
					texts="이미지들어가면 될듯요"
					confirms="다음 단계로"
					colors="#FF7738"
				/>
			</div>
		</GameQuestionContainer>
	);
}

export default GameQuestion;
