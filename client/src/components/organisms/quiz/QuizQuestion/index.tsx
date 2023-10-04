import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import Title from 'components/atoms/quiz/Title';
import Question from 'components/atoms/quiz/Question';
import { WeeklyQuizQuestionRequestApiBody } from 'types/api';
import { DUMMY_WEEKLY_QUIZS } from 'constants/dummyquiz';
import QuizButton from 'components/atoms/common/QuizButton';
import Swal from 'sweetalert2';
import { getWeeklyQuizQuestionApi } from 'utils/apis/quiz';
import { QuizQuestionContainer } from './style';

interface IQuizQuestionProps {
	setStep: Dispatch<SetStateAction<number>>;
	setScore: Dispatch<SetStateAction<number>>;
}

function QuizQuestion(props: IQuizQuestionProps) {
	const { setStep, setScore } = props;
	const [isDone, setIsDone] = useState(false);
	const [question, setQuestion] = useState<WeeklyQuizQuestionRequestApiBody[]>(DUMMY_WEEKLY_QUIZS);
	const [ques, setQues] = useState<WeeklyQuizQuestionRequestApiBody[]>([]);
	const [que, setQue] = useState('');
	const [num, setNum] = useState(0);
	const [currentIndex, setCurrentIndex] = useState(0);

	const getQuizQuestions = async () => {
		try {
			const memberkey = localStorage.getItem('memberkey');
			console.log('멤버키입니다.');
			console.log(memberkey);
			if (memberkey) {
				const response = await getWeeklyQuizQuestionApi(memberkey);
				const weeklyQuiz = response.data.data;
				setQues([weeklyQuiz]);
				console.log(ques);
				// console.log('::getWeeklyQuizQuestionApi', response);
				// console.log(weeklyQuiz.answerWord);
				setQue(weeklyQuiz.answerWord);
				console.log(que);
			}
		} catch (e) {
			console.log(e);
		}
	};

	useEffect(() => {
		if (num === 0) {
			getQuizQuestions();
			setNum(1);
		}
	}, [num]);

	const handleClick = (selectedAnswer: string) => {
		const correctAnswer = question[currentIndex].answerWord;

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
					setNum(0);
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
					setNum(0);
				});
			}
		}
	};

	const nextLevelClick = (selectedAnswer: string) => {
		const correctAnswer = question[currentIndex].answerWord;

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
					setNum(0);
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
					setNum(0);
				});
			}
		}
	};

	useEffect(() => {
		setQuestion(DUMMY_WEEKLY_QUIZS);
		setIsDone(false);
	});

	return (
		<QuizQuestionContainer>
			<Title effectText={question[currentIndex].no} text="번 문제" />
			<Question text={question[currentIndex].description} />
			<hr className="hr" />
			<div className="quiz-button">
				{currentIndex === 4 ? (
					<>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[0]}
							handleClick={() => nextLevelClick(question[currentIndex].contents[0])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[1]}
							handleClick={() => nextLevelClick(question[currentIndex].contents[1])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[2]}
							handleClick={() => nextLevelClick(question[currentIndex].contents[2])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[3]}
							handleClick={() => nextLevelClick(question[currentIndex].contents[3])}
						/>
					</>
				) : (
					<>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[0]}
							handleClick={() => handleClick(question[currentIndex].contents[0])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[1]}
							handleClick={() => handleClick(question[currentIndex].contents[1])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[2]}
							handleClick={() => handleClick(question[currentIndex].contents[2])}
						/>
						<QuizButton
							color="Normal"
							text={question[currentIndex].contents[3]}
							handleClick={() => handleClick(question[currentIndex].contents[3])}
						/>
					</>
				)}
			</div>
		</QuizQuestionContainer>
	);
}

export default QuizQuestion;
