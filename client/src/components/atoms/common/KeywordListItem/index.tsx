import React from 'react';
import { KeywordListItemContainer } from './style';

interface IKeywordListItemProps {
	text: string;
}
function KeywordListItem(props: IKeywordListItemProps) {
	const { text } = props;
	return <KeywordListItemContainer>{text}</KeywordListItemContainer>;
}

export default KeywordListItem;
