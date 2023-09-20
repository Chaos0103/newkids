import React, { Dispatch, SetStateAction } from 'react';
import { ReactComponent as CheckIcon } from 'assets/icons/check.svg';
import { CheckTextButtonWrapper } from './style';

interface ICheckTextButtonProps {
	value: boolean;
	setValue: Dispatch<SetStateAction<boolean>>;
	text: string;
}

function CheckTextButton(props: ICheckTextButtonProps) {
	const { value, setValue, text } = props;

	return (
		<CheckTextButtonWrapper value={value}>
			<button type="button" onClick={() => setValue(!value)}>
				<CheckIcon />
				{text}
			</button>
		</CheckTextButtonWrapper>
	);
}

export default CheckTextButton;
