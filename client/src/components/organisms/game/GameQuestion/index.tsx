import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import useMovePage from 'hooks/useMovePage';
import Swal from 'sweetalert2';
import Title from 'components/atoms/game/Title';
import Question from 'components/atoms/quiz/Question';
import Input from 'components/atoms/common/Input';
import { DUMMY_QUIZS } from 'constants/dummyquiz';
import { QuizQuestionRequestApiBody } from 'types/api';
import SoundBarLottie from 'components/atoms/lottie/SoundBarLottie';
import { getSpeech } from 'utils/common/tts';
import Button from 'components/atoms/common/Button';
import { getQuizQuestionApi } from 'utils/apis/quiz';
import EmptyBoxLottie from 'components/atoms/lottie/EmptyBoxLottie';
import ScrollToTop from 'components/atoms/common/ScrollToTop';
import { GameQuestionContainer } from './style';

interface IGameQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
	setScore: Dispatch<SetStateAction<number>>;
}

function GameQuestion(props: IGameQuestionProps) {
	const { setStep, setScore } = props;
	const [movePage] = useMovePage();
	const [isDone, setIsDone] = useState(false);
	const [question, setQuestion] = useState<QuizQuestionRequestApiBody[]>(DUMMY_QUIZS);
	const [currentIndex, setCurrentIndex] = useState(0);
	const [answer, setAnswer] = useState('');

	const getQuizQuestions = async () => {
		try {
			const memberkey = localStorage.getItem('memberkey');
			if (memberkey) {
				await getQuizQuestionApi(memberkey);
			}
		} catch (e) {
			console.log(e);
		}
	};

	const articleButton = () => {
		if (!isDone) {
			movePage('/article');
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
					confirmButtonText: '확인',
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
					confirmButtonText: '확인',
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
					confirmButtonText: '확인',
				}).then(() => {
					setStep(3);
					setScore((prevIndex) => prevIndex + 1);
				});
			} else {
				Swal.fire({
					imageUrl: 'https://ifh.cc/g/4yzNys.gif',
					imageHeight: 200,
					title: '아쉬워요... 오답입니다.',
					confirmButtonText: '확인',
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
			<ScrollToTop />
			<div className="question-box">
				{currentIndex === -1 ? (
					<div>
						<EmptyBoxLottie />
						<Title effectText="" text="이런! 단어장에 단어가 없어요!" />
						<h1 className="h1">
							단어장에 적어도 10개 이상의 단어가 있어야 해요.
							<br /> 단어를 추가하려면 기사 옆에 사전에서 단어장을 추가할 수 있어요.
						</h1>
						<div className="article-button-wrapper">
							<Button size="m" radius="m" color="Primary" text="기사 보러가기" handleClick={articleButton} />
						</div>
					</div>
				) : (
					<div>
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
					</div>
				)}
			</div>
		</GameQuestionContainer>
	);
}

export default GameQuestion;
