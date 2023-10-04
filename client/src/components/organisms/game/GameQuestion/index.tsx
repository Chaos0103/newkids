import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Swal from 'sweetalert2';
import Title from 'components/atoms/game/Title';
import Question from 'components/atoms/quiz/Question';
import Input from 'components/atoms/common/Input';
import { DUMMY_QUIZS } from 'constants/dummyquiz';
import { QuizQuestionRequestApiBody } from 'types/api';
import SoundBarLottie from 'components/atoms/lottie/SoundBarLottie';
import { getSpeech } from 'utils/apis/tts';
import Button from 'components/atoms/common/Button';
import { getQuizQuestionApi } from 'utils/apis/quiz';
import { GameQuestionContainer } from './style';

interface IGameQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
	setScore: Dispatch<SetStateAction<number>>;
}

function GameQuestion(props: IGameQuestionProps) {
	const { setStep, setScore } = props;
	const [isDone, setIsDone] = useState(false);
	const [question, setQuestion] = useState<QuizQuestionRequestApiBody[]>(DUMMY_QUIZS);
	const [currentIndex, setCurrentIndex] = useState(0);
	const [answer, setAnswer] = useState('');

	const getQuizQuestions = async () => {
		try {
			const memberkey = localStorage.getItem('memberkey');
			console.log('::memberkey : ', memberkey);
			if (memberkey) {
				const response = await getQuizQuestionApi(memberkey);
				console.log('::getQuizQuestionApi', response);
				console.log(response.data);
			}
		} catch (e) {
			console.log(e);
		}
	};

	const handleSpeechButton = () => {
		const voiceValue = question[currentIndex].word;
		getSpeech(voiceValue);
	};

	const handleClick = (selectedAnswer: string) => {
		const correctAnswer = question[currentIndex].word;

		if (!isDone) {
			if (selectedAnswer === correctAnswer) {
				Swal.fire({
					imageUrl: 'https://ifh.cc/g/Y4p2ln.gif',
					imageHeight: 200,
					title: '축하해요! 정답입니다.',
				}).then(() => {
					setCurrentIndex((prevIndex) => prevIndex + 1);
					setIsDone(true);
					setScore((prevIndex) => prevIndex + 1);
					setAnswer('');
				});
			} else {
				Swal.fire({
					imageUrl: 'https://ifh.cc/g/4yzNys.gif',
					imageHeight: 200,
					title: '아쉬워요... 오답입니다.',
				}).then(() => {
					setCurrentIndex((prevIndex) => prevIndex + 1);
					setIsDone(true);
					setAnswer('');
				});
			}
		}
	};

	const nextLevelClick = (selectedAnswer: string) => {
		const correctAnswer = question[currentIndex].word;

		if (!isDone) {
			if (selectedAnswer === correctAnswer) {
				Swal.fire({
					imageUrl: 'https://ifh.cc/g/Y4p2ln.gif',
					imageHeight: 200,
					title: '축하해요! 정답입니다.',
				}).then(() => {
					setStep(3);
					setScore((prevIndex) => prevIndex + 1);
				});
			} else {
				Swal.fire({
					imageUrl: 'https://ifh.cc/g/4yzNys.gif',
					imageHeight: 200,
					title: '아쉬워요... 오답입니다.',
				}).then(() => {
					setStep(3);
					setScore((prevIndex) => prevIndex);
				});
			}
		}
	};

	useEffect(() => {
		setIsDone(false);
		setQuestion(DUMMY_QUIZS);
		getQuizQuestions();
	});

	return (
		<GameQuestionContainer>
			<Title effectText={question[currentIndex].no} text="번 문제" />
			<div className="question-wrapper">
				<div className="question">
					<Question text={question[currentIndex].description} />
				</div>
				<button type="button" onClick={handleSpeechButton}>
					<SoundBarLottie />
				</button>
			</div>
			<hr className="hr" />
			<div className="input-wrapper">
				<Input type="text" value={answer} setValue={setAnswer} placeholder="정답을 입력해주세요." />
				<div className="button-wrapper">
					{currentIndex === 9 ? (
						<Button size="s" radius="m" color="Primary" text="확인" handleClick={() => nextLevelClick(answer)} />
					) : (
						<Button size="s" radius="m" color="Primary" text="확인" handleClick={() => handleClick(answer)} />
					)}
				</div>
			</div>
		</GameQuestionContainer>
	);
}

export default GameQuestion;
