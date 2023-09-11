import React from 'react';
import { ReactComponent as Search } from 'assets/icons/search.svg';
import { SearchBarContainer } from './style';

interface ISearchBarProps {
	size: 's' | 'l' | 'full';
	confirmSearch: () => void;
}
function SearchBar(props: ISearchBarProps) {
	const { size, confirmSearch } = props;

	return (
		<SearchBarContainer $size={size}>
			<input type="text" />
			<button type="button" className="confirm-search-btn-wrapper" onClick={confirmSearch}>
				<Search />
			</button>
		</SearchBarContainer>
	);
}

export default SearchBar;
