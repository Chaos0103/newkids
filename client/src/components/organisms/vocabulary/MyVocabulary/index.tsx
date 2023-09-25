import React from 'react';
import { ReactComponent as Notebook } from 'assets/imgs/notebook.svg';
import { MyVocabularyContainer } from './style';

function MyVocabulary() {
	return (
		<MyVocabularyContainer>
			<div className="notebook-size">
				<Notebook />
			</div>
		</MyVocabularyContainer>
	);
}

export default MyVocabulary;
