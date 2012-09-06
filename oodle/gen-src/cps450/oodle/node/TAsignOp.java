/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class TAsignOp extends Token
{
    public TAsignOp()
    {
        super.setText(":=");
    }

    public TAsignOp(int line, int pos)
    {
        super.setText(":=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TAsignOp(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTAsignOp(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TAsignOp text.");
    }
}
