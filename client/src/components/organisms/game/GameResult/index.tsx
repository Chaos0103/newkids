import React, { Dispatch, SetStateAction } from 'react';
import { GameResultWrapper } from './style';

interface IGameResultProps {
	setStep: Dispatch<SetStateAction<number>>;
}

function GameResult({ setStep }: IGameResultProps) {
	console.log(setStep);
	return <GameResultWrapper>안녕하세요! 테스트입니다.</GameResultWrapper>;
}

export default GameResult;
