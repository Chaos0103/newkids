import React from 'react';
import { TitleWrapper } from './style';

interface ITitleProps {
	effectText: string;
	text: string;
}

function Title({ effectText, text }: ITitleProps) {
	return (
		<TitleWrapper>
			<b className="main-title">{effectText}</b>
			{text}
		</TitleWrapper>
	);
}

export default Title;
