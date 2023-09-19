import React, { Dispatch, SetStateAction } from 'react';
import QuizImage from 'components/atoms/quiz/QuizImage';
import Title from 'components/atoms/quiz/Title';
import { QuizWordsWrapper } from './style';

interface IQuizWordsProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function QuizWords({ setStep }: IQuizWordsProps) {
	console.log(setStep);
	return (
		<QuizWordsWrapper>
			<QuizImage />
			<Title text="이번 퀴즈에서 배운 단어들이에요" effectText="" />
		</QuizWordsWrapper>
	);
}

export default QuizWords;
