import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/game/Title';
import Question from 'components/atoms/quiz/Question';
import Alert from 'components/organisms/common/Alert';
import Input from 'components/atoms/common/Input';
import { DUMMY_QUIZS, DUMMY_ANSWERS_1 } from 'constants/dummyquiz';
import { QuizAnswerCheckApiBody, QuizQuestionRequestApiBody } from 'types/api';
import { GameQuestionContainer } from './style';

interface IGameQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function GameQuestion(props: IGameQuestionProps) {
	const { setStep } = props;
	const [question, setQuestion] = useState<QuizQuestionRequestApiBody[]>(DUMMY_QUIZS);
	const [answer, setAnswer] = useState<QuizAnswerCheckApiBody[]>(DUMMY_ANSWERS_1);
	const [answer2, setAnswer2] = useState('');

	question.forEach((que) => console.log(que.no));
	question.forEach((que) => {
		console.log(que.word);
	});
	question.forEach((que) => console.log(que.description));
	useEffect(() => {
		setQuestion(DUMMY_QUIZS);
	});

	useEffect(() => {
		setAnswer(DUMMY_ANSWERS_1);
	}, []);

	console.log(question);
	console.log('=================');
	console.log(answer);

	return (
		<GameQuestionContainer>
			<Title text="번 문제" effectText={question[0].no} />
			<h1 className="meaning">뜻)</h1>
			<Question text={question[0].description} />
			<hr className="hr" />
			<h2>{question[0].no}</h2>
			<div className="input-wrapper">
				<Input type="text" value={answer2} setValue={setAnswer2} placeholder="정답을 입력해주세요." />
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
