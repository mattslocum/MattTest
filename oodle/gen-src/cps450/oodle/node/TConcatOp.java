/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class TConcatOp extends Token
{
    public TConcatOp()
    {
        super.setText("&");
    }

    public TConcatOp(int line, int pos)
    {
        super.setText("&");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TConcatOp(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTConcatOp(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TConcatOp text.");
    }
}
