import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/game/Title';
import Question from 'components/atoms/quiz/Question';
import Alert from 'components/organisms/common/Alert';
import Input from 'components/atoms/common/Input';
import { DUMMY_QUIZS } from 'constants/dummyquiz';
import { QuizQuestionRequestApiBody } from 'types/api';
import { GameQuestionFourContainer } from './style';

interface IGameQuestionFourProps {
	num: number;
	setStage: Dispatch<SetStateAction<number>>;
	setNum: Dispatch<SetStateAction<number>>;
}

function GameQuestionFour(props: IGameQuestionFourProps) {
	const { setNum, setStage, num } = props;
	const [question, setQuestion] = useState<QuizQuestionRequestApiBody[]>(DUMMY_QUIZS);
	const [answer, setAnswer] = useState('');

	useEffect(() => {
		setNum(3);
		setQuestion(DUMMY_QUIZS);
	});

	return (
		<GameQuestionFourContainer>
			<Title effectText={question[3].no} text="번 문제" />
			<h1 className="meaning">뜻)</h1>
			<Question text={question[3].description} />
			<hr className="hr" />
			<div className="input-wrapper">
				<Input type="text" value={answer} setValue={setAnswer} placeholder="정답을 입력해주세요." />
				<Alert
					num={num}
					setNum={setNum}
					setStage={setStage}
					imageUrls="https://ifh.cc/g/Rkn9J6.jpg"
					imageHeights={200}
					titles={answer === question[3].word ? '정답입니다' : '오답입니다.'}
					confirms="다음 단계로"
					colors="#FF7738"
				/>
			</div>
		</GameQuestionFourContainer>
	);
}

export default GameQuestionFour;
