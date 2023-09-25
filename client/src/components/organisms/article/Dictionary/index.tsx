import React, { useState } from 'react';
import SearchBar from 'components/atoms/common/SearchBar';
import { DictionaryContainer } from './style';

function Dictionary() {
	const [searchWord, setSearchWord] = useState('');

	const search = async () => {
		try {
			alert(`${searchWord} 검색`);
		} catch (error) {
			console.error(error);
		}
	};

	return (
		<DictionaryContainer>
			<h3>뜻을 모르는 단어가 있나요?</h3>
			<SearchBar
				value={searchWord}
				setValue={setSearchWord}
				size="full"
				confirmSearch={search}
				placeholder="검색어를 입력하세요"
				color="SubSecond"
			/>
		</DictionaryContainer>
	);
}

export default Dictionary;
