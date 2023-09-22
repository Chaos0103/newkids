import React from 'react';
import { AreaTitleWrapper } from './style';

interface IAreaTitleProps {
	title: string;
}
function AreaTitle(props: IAreaTitleProps) {
	const { title } = props;
	return <AreaTitleWrapper>{title}</AreaTitleWrapper>;
}

export default AreaTitle;
