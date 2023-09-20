import React, { Dispatch, SetStateAction, ChangeEvent, ReactNode } from 'react';

import { InputWrapper } from './style';

interface IInputProps {
	type: string;
	placeholder: string;
	value: string;
	setValue: Dispatch<SetStateAction<string>>;
	Icon?: ReactNode;
	disabled?: boolean;
}

function Input(props: IInputProps) {
	const { type, placeholder, value, setValue, Icon, disabled } = props;

	const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
		setValue(e.target.value);
	};

	return (
		<InputWrapper $isIcon={Icon !== undefined}>
			<div className="icon">{Icon}</div>
			<input type={type} placeholder={placeholder} value={value} onChange={handleChange} disabled={disabled} />
		</InputWrapper>
	);
}

export default Input;
