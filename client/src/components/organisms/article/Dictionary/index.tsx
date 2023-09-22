import React, { useState } from 'react';
import SearchBar from 'components/atoms/common/SearchBar';
import { DictionaryContainer } from './style';

function Dictionary() {
	const [value, setValue] = useState('');

	return (
		<DictionaryContainer>
			<SearchBar
				value={value}
				setValue={setValue}
				size="s"
				confirmSearch={() => {}}
				placeholder="검색어를 입력하세요"
				color="SubSecond"
			/>
		</DictionaryContainer>
	);
}

export default Dictionary;
