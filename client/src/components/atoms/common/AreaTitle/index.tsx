import React from 'react';
import { AreaTitleWrapper } from './style';

interface IAreaTitleProps {
	title: string;
	color?: 'Primary' | 'SubFirst' | 'Black';
	subStr?: string;
}
function AreaTitle(props: IAreaTitleProps) {
	const { title, color, subStr } = props;
	return (
		<AreaTitleWrapper $color={color ?? 'Black'}>
			{title}
			{subStr ? <span className="subStr">{subStr}</span> : <span />}
		</AreaTitleWrapper>
	);
}

export default AreaTitle;
