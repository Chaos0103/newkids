import React from 'react';
import { DUMMY_WORD_CLOUD } from 'constants/dummy';
import ReactWordcloud, { OptionsProp } from 'react-wordcloud';
import { WordCloudContainer } from './style';
import 'tippy.js/dist/tippy.css';
import 'tippy.js/animations/scale.css';

interface IWordKeyword {
	text: string;
	value: number;
}

function KeywordCloud() {
	const options: OptionsProp = {
		fontFamily: 'Pretendard',
		fontSizes: [20, 60],
	};

	const callbacks = {
		onWordClick: (word: IWordKeyword) => console.log(word),
	};

	return (
		<WordCloudContainer>
			<ReactWordcloud words={DUMMY_WORD_CLOUD} options={options} callbacks={callbacks} />
		</WordCloudContainer>
	);
}

export default KeywordCloud;
