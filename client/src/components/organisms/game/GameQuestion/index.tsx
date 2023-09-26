import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/game/Title';
import Question from 'components/atoms/quiz/Question';
import Alert from 'components/organisms/common/Alert';
import Input from 'components/atoms/common/Input';
import { DUMMY_QUIZS } from 'constants/dummyquiz';
import { QuizQuestionRequestApiBody } from 'types/api';
import { GameQuestionContainer } from './style';

interface IGameQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
	setStage: Dispatch<SetStateAction<number>>;
	setNum: Dispatch<SetStateAction<number>>;
	num: number;
}

function GameQuestion(props: IGameQuestionProps) {
	const { setNum, setStep, setStage, num } = props;
	const [question, setQuestion] = useState<QuizQuestionRequestApiBody[]>(DUMMY_QUIZS);
	const [answer, setAnswer] = useState('');

	useEffect(() => {
		setNum(2);
		setQuestion(DUMMY_QUIZS);
	});

	return (
		<GameQuestionContainer>
			<Title effectText={question[0].no} text="번 문제" />
			<h1 className="meaning">뜻)</h1>
			<Question text={question[0].description} />
			<hr className="hr" />
			<div className="input-wrapper">
				<Input type="text" value={answer} setValue={setAnswer} placeholder="정답을 입력해주세요." />
				<Alert
					num={num}
					setNum={setNum}
					setStage={setStage}
					setStep={setStep}
					imageUrls="https://ifh.cc/g/Rkn9J6.jpg"
					imageHeights={200}
					titles={answer === question[0].word ? '정답입니다' : '오답입니다.'}
					confirms="다음 단계로"
					colors="#FF7738"
				/>
			</div>
		</GameQuestionContainer>
	);
}

export default GameQuestion;
