import React from 'react';
import { QuestionWrapper } from './style';

interface IQuestionProps {
	text: string;
}

function Question({ text }: IQuestionProps) {
	return <QuestionWrapper>{text}</QuestionWrapper>;
}

export default Question;
